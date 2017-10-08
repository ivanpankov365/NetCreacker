package ru.ncedu.java.tasks;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * ���� ������:<br/>
 * - ����������� � XPath �����������: ����� ���������, ���������� � ������������� ����, 
 *     ���, �������, �������.<br/>
 * - ��������� ������ ������������ ������� �� ����������� �������� � ������������� ��������.<br/>
 * - ����������� � Java XPath API.<br/>
 * <br/>
 * �������<br/>
 * ������������ � ����� XML �����������: emp.xml (emp.xsd) � emp-hier.xml.<br/> 
 * � ������� XPath ������� ������� �������� (���������) ��� ������� ������ ������� 
 *   ��� ������� �� ���� ����������; XPath ��� ������� �� ���������� ����� ����������.<br/>
 * 1) ��� ��������� ������ (deptno) ������� ���� �����������.<br/>
 * 2) ������� ��� ������ ������������������� ����������.<br/>
 * 3) ��� ��������� ������ (deptno) ������� ��� ������ ������������������ ����������.<br/> 
 * 4) ������� ���� ������� ���������� (�������� �������, ���� ��� ��� ��� ���������).<br/>
 * 5) ������� ���� �����������, �� ���������� �����������.<br/>
 * 6) ����� ����� ��������� ����� (����� ������� ���� ����������� ����� �������).<br/>
 * 7) ��� ��������� ���������� (empno) ����� ���� ������, ������� � ���������� � ���� �� ���������.<br/>
 * �� ���� �������, ������������ Element[], ������ ������������ ��������, ��������������� �����������.<br/>
 * ���������� 1: �������������� �� Node'�� (NodeList) � Element'� (Element[]) �� �������� ���������� ��� �������� 
 *  ������� � ������ (��� ��� ���� ����� ��������� ������ ������� ��� ��� �������� �������������� ��������).<br/>
 * ���������� 2: ����� �������� - ��� ��������� ����������, � �� ��������� � job=MANAGER! <br/>
 * <br/>
 * ����������:<br/>
 * - ������������ ����������� XPath API.<br/>
 * - ������ ������� ������ ��������� ������ ���� ����� XPath API � ���������� XPath ����������.<br/>
 * - ������������ ���� ��� ������� ������ �� ������������.<br/>
 * 
 * @author Sergey Pankratov
 */
public interface XPathCaller {
	/**
	 * ��� ��������� ������ ������� ���� �����������.
	 * @param src XML �������� ��� ������
	 * @param deptno ����� ������ deptno
	 * @param docType "emp" - ��� ����� ���� emp.xml; "emp-hier" - ��� ����� ���� emp-hier.xml
	 * @throws XPathExpressionException 
	 */
	Element[] getEmployees (Document src, String deptno, String docType) throws XPathExpressionException;
	
	/**
	 * ������� ��� ������ ������������������� ����������.
	 * @param src XML �������� ��� ������
	 * @param docType "emp" - ��� ����� ���� emp.xml; "emp-hier" - ��� ����� ���� emp-hier.xml
	 */
	String getHighestPayed(Document src, String docType);
	
	/**
	 * ������� ��� ������ ������������������� ���������� (������, ���� ����� ���������).
	 * @param src XML �������� ��� ������
	 * @param deptno ����� ������ deptno
	 * @param docType "emp" - ��� ����� ���� emp.xml; "emp-hier" - ��� ����� ���� emp-hier.xml
	 */
	String getHighestPayed(Document src, String deptno, String docType);
	/**
	 * ������� ���� ������� ���������� (�������� �������, ���� ��� ��� ��� ���������)
	 * @param src XML �������� ��� ������
	 * @param docType "emp" - ��� ����� ���� emp.xml; "emp-hier" - ��� ����� ���� emp-hier.xml
	 */
	Element[] getTopManagement(Document src, String docType);
	/**
	 * ������� ���� �����������, �� ���������� �����������.
	 * �������, ��� ��������� �� �������� ����������, ���� � ���� ��� �����������.
	 * @param src XML �������� ��� ������
	 * @param docType "emp" - ��� ����� ���� emp.xml; "emp-hier" - ��� ����� ���� emp-hier.xml
	 */
	Element[] getOrdinaryEmployees(Document src, String docType);

	/**
	 * ��� ��������� ����������(empno) ����� ���� ������, ������� � ���������� � ���� �� ���������.
	 * @param src XML �������� ��� ������
	 * @param empno ����� ���������� empno
	 * @param docType "emp" - ��� ����� ���� emp.xml; "emp-hier" - ��� ����� ���� emp-hier.xml
	 */
	Element[] getCoworkers(Document src, String empno, String docType);
}
