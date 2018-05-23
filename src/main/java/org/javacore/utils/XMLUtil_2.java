/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.utils;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

/**
 * @author liuwei
 */
public class XMLUtil_2 {
	public static Marshaller getMarshaller(Class<?> beanClass, boolean formatted, String encoding) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);

			Marshaller marshaller = jaxbContext.createMarshaller();
			if (formatted) {
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			}
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			// no standalone attribute
			marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
					"<?xml version=\"1.0\" encoding=\"" + encoding + "\"?>");
			return marshaller;
		} catch (JAXBException e) {
			throw new RuntimeException("Error when creating marshaller", e);
		}
	}

	/**
	 * 将XML字符串反序列化为Java对象
	 *
	 * @param xmlStr
	 *            待反序列化的XML字符串
	 * @param pojoClass
	 *            需要反序列化的类型
	 * @throws JAXBException
	 * @return
	 */
	public static <T> Object fromXml(String xmlStr, Class<T> pojoClass) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(pojoClass);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		SAXParserFactory sax = SAXParserFactory.newInstance();
		sax.setNamespaceAware(false);
		XMLReader xmlReader = sax.newSAXParser().getXMLReader();

		InputStream in = new ByteArrayInputStream(xmlStr.getBytes());
		Source source = new SAXSource(xmlReader, new InputSource(new StringReader(xmlStr)));

		Object object = unmarshaller.unmarshal(source);
		return object;
	}
}
