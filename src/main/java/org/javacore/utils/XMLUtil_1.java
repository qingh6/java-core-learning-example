/**
 * Copyright (c) 2017, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.javacore.utils;

import org.apache.commons.io.IOUtils;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @author Bruce
 *
 */
public class XMLUtil_1 {
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

	public static Unmarshaller getUnmarshaller(Class<?> beanClass) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
			return jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			throw new RuntimeException("Error when creating marshaller", e);
		}
	}

	public static <T> T fromXML(Class<T> beanClass, String xml) {
		Unmarshaller unmarshaller = getUnmarshaller(beanClass);
		try {
			@SuppressWarnings("unchecked")
			T unmarshal = (T) unmarshaller.unmarshal(new StringReader(xml));
			return unmarshal;
		} catch (JAXBException e) {
			throw new RuntimeException("Error when unmarshalling", e);
		}
	}

	public static <T> T fromXML(Class<T> beanClass, Reader reader) {
		Unmarshaller unmarshaller = getUnmarshaller(beanClass);
		try {
			@SuppressWarnings("unchecked")
			T unmarshal = (T) unmarshaller.unmarshal(reader);
			return unmarshal;
		} catch (JAXBException e) {
			throw new RuntimeException("Error when unmarshalling", e);
		}
	}

	public static String toXMLString(Object obj, boolean formatted, String encoding) {
		Marshaller marshaller = getMarshaller(obj.getClass(), formatted, encoding);
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			marshaller.marshal(obj, baos);
			return new String(baos.toByteArray(), encoding);
		} catch (JAXBException | UnsupportedEncodingException e) {
			throw new RuntimeException("Error when marshalling", e);
		} finally {
			IOUtils.closeQuietly(baos);
		}
	}

	public static void toXMLFile(Object obj, boolean formatted, File file, String encoding) {
		Marshaller marshaller = getMarshaller(obj.getClass(), formatted, encoding);
		file.getParentFile().mkdirs();
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(file);
			marshaller.marshal(obj, fout);
		} catch (JAXBException | IOException e) {
			throw new RuntimeException("Error when marshalling", e);
		} finally {
			IOUtils.closeQuietly(fout);
		}
	}
}
