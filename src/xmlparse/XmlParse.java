package xmlparse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import beans.Message;

public class XmlParse {

	public XmlParse() {
	}

	public static Date convertStringToDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy/MM/dd'T'HH:mm:ss.SSSZ");
		return format.parse(date);
	}

	// metodo que realiza o parse de um xml para uma noticia
	public static List<Message> parseXmlToObjectNews(String xml) {
		DocumentBuilder builder;
		int qtde = 0;
		List<Message> listaMsgs = new ArrayList<Message>();
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(xml.getBytes());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setNamespaceAware(false);
			factory.setValidating(false);
			builder = factory.newDocumentBuilder();
			Document d = builder.parse(input);
			qtde = d.getElementsByTagName("message").getLength();

			for (int i = 0; i < qtde; i++) {
				Message m = new Message();
				m.setId(Long.parseLong((d.getElementsByTagName("id").item(i).getTextContent())));
				m.setUser(d.getElementsByTagName("user").item(i).getTextContent());
				m.setTitulo(d.getElementsByTagName("title").item(i).getTextContent());
				m.setText(d.getElementsByTagName("text").item(i).getTextContent());
				m.setImage(d.getElementsByTagName("image").item(i).getTextContent());
				m.setDate(Long.parseLong(d.getElementsByTagName("date").item(i).getTextContent()));

				listaMsgs.add(m);
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaMsgs;

	}

	/**
	 * Método que retorna uma session ou vazio caso não consiga converter o xml
	 * @param xml
	 * @return String com o session
	 */
	public static String parseSession(String xml) {

		Document d = null;
		String texto = null;

		try {

			ByteArrayInputStream input = new ByteArrayInputStream(xml.getBytes());

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setNamespaceAware(false);
			factory.setValidating(false);

			DocumentBuilder builder = factory.newDocumentBuilder();

			d = builder.parse(input);

			texto = d.getElementsByTagName("session").item(0).getTextContent();

		} catch (SAXException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return "";
		}

		return texto;

	}

	// metodo que realiza o parse de um xml para uma response

	// metodo que recupera uma lista de objetos

	// xml do facebook
	public static String xmlFacebookToken(String token) {
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?><facebook-token>"
				+ token + "</facebook-token>";
	}

	public static String xmlSessionNoticias(String session) {
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?><session>" + session
				+ "</session>";
	}
	
	public static String xmlSessioResponse(String xml) {

		String session = "";

		try {

			ByteArrayInputStream input = new ByteArrayInputStream(
					xml.getBytes());

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setNamespaceAware(false);
			factory.setValidating(false);

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d = builder.parse(input);
			session = d.getElementsByTagName("nomeUsuario").item(1)
					.getTextContent();

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return session;

	}

}
