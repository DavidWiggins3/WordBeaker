package com.davidwiggins3.wordbeaker.ProjectReader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.davidwiggins3.wordbeaker.DocReader.RtfReader;

public class ScrivenerProjectReader extends ProjectReader {

	public RtfReader rtfReader = new RtfReader();

	@Override
	int readWordCount(String path) throws ReaderException {

		int totalWordCount = 0;
		
		try {
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			NodeList binderItems = doc.getElementsByTagName("BinderItem");

			// find the draft folder
			Element draftFolder = null;
			for (int i = 0; i < binderItems.getLength(); i++) {
				draftFolder = (Element) binderItems.item(0);
				if (draftFolder.getAttribute("Type") == "DraftFolder") {
					break;
				}
			}

			
			
			NodeList includes = draftFolder.getElementsByTagName("IncludeInCompile");
			for (int i = 0; i < includes.getLength(); i++) {
				Node includeInCompileNode = includes.item(i);
				if (includeInCompileNode.getFirstChild().getNodeValue().compareTo("Yes") == 0) {
					Node metaDataNode = includeInCompileNode.getParentNode();
					// Element metaDataElement = (Element) metaDataNode;
					// NodeList fileExtensionNodes = metaDataElement.getElementsByTagName("FileExtension");
					// if (fileExtensionNodes.getLength() == 1) {
					//
					// if (fileExtensionNodes.item(0).getFirstChild().getNodeValue().compareTo("rtf") == 0) {

					Element binderItemElement = (Element) metaDataNode.getParentNode();
					if (binderItemElement.getAttribute("Type").compareTo("Text") == 0) {
						String binderItemId = binderItemElement.getAttribute("ID");
						String binderItemTitle = binderItemElement.getElementsByTagName("Title").item(0).getFirstChild().getNodeValue();
						// TODO go count words in referenced file

						try {
							int count = rtfReader.readWordCount("TestFiles\\Tutorial.scriv\\Files\\Docs\\" + binderItemId + ".rtf");
							System.out.println(binderItemId + ".rtf : " + binderItemTitle + " count = " + count);
							totalWordCount += count;
						} catch (ReaderException e) {
							// keep going. It's just a file that hasn't been created yet
						}

					}
					// }
					// }
				}
			}

		} catch (ParserConfigurationException | IOException | SAXException e) {
			throw new ReaderException(e);
		}

		System.out.println("TOTAL = "+totalWordCount);
		return totalWordCount;

	}

}
