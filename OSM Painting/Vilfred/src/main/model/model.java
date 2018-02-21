package main.model;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;
import main.controller.Controller;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.util.*;

public class Model {
    GraphicsContext gc ;

    Model() {

    }

    private void readFromOSM(String filename) {
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new OSMHandler());
            xmlReader.parse(filename);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    private class OSMHandler extends DefaultHandler {
        Map<Long, OSMNode> idToNode = new HashMap<>();
        OSMWay way;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName){
                case "node":
                    Double lon = Double.parseDouble(attributes.getValue("lon"));
                    Double lat = Double.parseDouble(attributes.getValue("lat"));
                    Long id = Long.parseLong(attributes.getValue("id"));
                    this.idToNode.put(id, new OSMNode(lon, lat));
                    break;
                case "way":
                    this.way = new OSMWay();
                    break;
                case "nd":
                    this.way.add(this.idToNode.get(Long.parseLong(attributes.getValue("ref"))));
                default:
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (qName){
                case "way":

                    OSMNode node;
                    for(int i = 1; i< this.way.size(); i ++){
                        node = this.way.get(i);


                    }
                    break;
                default:
                    break;
            }
        }
    }
}
