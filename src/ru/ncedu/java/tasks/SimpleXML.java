package ru.ncedu.java.tasks;

import java.io.InputStream;

import javax.xml.transform.Transformer;

import org.xml.sax.SAXException;

/**
 * ���� ������:<br/>
 * - ����������� � DOM API ��� ������ � XML-�������.<br/>
 * - ����������� � SAX API ��� ������� (parsing'�) XML �� ������ �������.<br/>
 * - ������, � ����� ������� ���������� ���������� DOM � SAX.<br/>
 * <br/>
 * �������<br/>
 * � ������ ���������� ������� ��� ����������� ���� �� ����� ������:<br/>
 * 1) �������� XML �� ����� � ���������� �������� ����.<br/>
 * 2) �������� ������������ (��������) XML ���������.<br/>
 * 
 * @author Sergey Pankratov
 */
public interface SimpleXML {
	/*
	 * � ������� DOM API � Java-���� ������� XML �������� ���� "<tagName>textNode</tagName>".
	 * � ���������, ��� ������ createXML("root","<R&D>") ������ ��������� <root>&lt;R&amp;D&gt;</root>.
	 * ����������:
	 * - ��������� ������ ���� ���������� (well-formed) XML ����������.
	 * - ������� ��������� ����� ��� ������ �������������� �������� �� ������ ���� ��������� � textNode.
	 * ���������� ������ � �������:
	 * - ������������ ������ DOM, � �� ������ ������ ��������� ������������ �������.
	 * - � ����� �������� � ��������� ���������� "<?xml...?>" ������� ������������ ����� 
	 *     {@link Transformer#setOutputProperty(String, String)} ��� �������� OMIT_XML_DECLARATION.
	 */
	//���� - ��� �� ����� �����������, �� ��������� ������������ � JAVADOC
	/**
	 * � ������� DOM API � Java-���� ������� XML �������� ���� "&lt;tagName&gt;textNode&lt;/tagName&gt;".<br/> 
	 * � ���������, ��� ������ createXML("root","&lt;R&amp;D&gt;") ������ ��������� &lt;root&gt;&amp;lt;R&amp;amp;D&amp;gt;&lt;/root&gt;.<br/>
	 * ����������:<br/>
	 * - ��������� ������ ���� ���������� (well-formed) XML ����������.<br/>
	 * - ������� ��������� ����� ��� ������ �������������� �������� �� ������ ���� ��������� � textNode.<br/>
	 * ���������� ������ � �������:<br/>
	 * - ������������ ������ DOM, � �� ������ ������ ��������� ������������ �������.<br/>
	 * - � ����� �������� � ��������� ���������� "&lt;?xml...?&gt;" ������� ������������ ����� 
	 *     {@link Transformer#setOutputProperty(String, String)} ��� �������� OMIT_XML_DECLARATION.
	 * @param tagName ��� ���� ��������
	 * @param textNode ��������� ���������� ����.
	 * @return ���������� XML �������� ��� ���������� "&lt;?xml...?&gt;"
	 */
	public String createXML(String tagName, String textNode);
	/**
	 * � ������� SAX API ���������, ��� �� �������� ������ ���������� ���������� (well-formed) XML-��������.<br/>
	 * � �������� ���������� ������� ��� ��������� �������� ���������,
	 *  � � ������ ������ (���� �������� �� well-formed) ������� {@link SAXException}.<br/>
	 * ����������: ������������ ������ �� ������ �������� �� ������� ��������� ���������.<br/>
	 * ����������: �� ������� ��������� �� ��������� ������������ ������������ ���� 
	 *  (� ����� �������� ����� �������������� namespace, �� ��� ����������).
	 * @param xmlStream ����� � XML ����������
	 * @return ��� ��������� ��������.
	 */
	public String parseRootElement(InputStream xmlStream) throws SAXException;
}
