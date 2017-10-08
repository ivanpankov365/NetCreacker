package ru.ncedu.java.tasks;

/**
 * ���� ������ - ����������� � ��������� � ������� � Java, ���������� ��������� ������,
 *  ������� ����������� ������� (����������� �������).<br/>
 * <br/>
 * �������<br/>
 * ����������� ����� ��� ������ � �������� (����� ������������ �����, ���������) 
 *  � ������� �������� ��������� ����������.<br/>
 * <br/>
 * ����������<br/>
 * ��������� ������, ������������ ������ ���������, ������ ��������������� ������ �������
 *  � ������� �������� ������� � ���� ���� "������".<br/>
 * ������ ������������ �������� ���������� Java, ����� ������� Math � Arrays.<br/>
 * ���� � ���� ���� ������������, �� ����� ��� ������ ���� ����������� ��� ����������:
 * <pre>public ArrayVectorImpl() {  }</pre>
 * ����� ������ �������� ��������� ����� ������ ������ ������������ � ��� ������ set-������.<br/>
 * <br/>
 * ����������<br/>
 * ������ ����� ������ ��� ����� ��������� � ��������� �������������� �������� (Exceptions).<br/>
 * 
 * @author Andrey Gavrilov
 * @author Alexander Kharichkin
 * @author Alexey Evdokimov
 */
public interface ArrayVector {
    /**
     * ������ ��� �������� ������� (���������� ����� �������).
     * ������������ ������ �� �����������.
     * @param elements �� ����� null
     */
    void set(double... elements);
    /**
     * ���������� ��� �������� �������. ������ �� �����������.
     */
    double[] get();
    /**
     * ���������� ����� ������� (�����, ��������� ��������� 
     *  � ������� �� �������� � ��������� ��������� ������� �������).<br/>
     * ������������� ������� ����� clone() � ������ ������� ��� ������������
     *   {@link System#arraycopy(Object, int, Object, int, int)}.
     */
    ArrayVector clone();
    /**
     * ���������� ����� ��������� �������.
     */
    int getSize();

    /**
     * �������� ������� �� �������. 
     * @param index � ������ ������ ������� �� ������� �������:<br/>
     *  �) ���� index<0, ������ �� ����������;<br/>
     *  �) ���� index>=0, ������ ������� ������������� ���, ����� index ���� ���������.
     */
    void set(int index, double value);
    /**
     * ���������� ������� �� �������.
     * @param index � ������ ������ ������� �� ������� ������� 
     *   ������ �������������� ArrayIndexOutOfBoundsException
     */
    double get(int index) throws ArrayIndexOutOfBoundsException;

    /**
     * ���������� ������������ ������� �������.
     */
    double getMax();
    /**
     * ���������� ����������� ������� �������.
     */
    double getMin();
    /**
     * ��������� �������� ������� � ������� �����������.
     */
    void sortAscending();

    /**
     * �������� ������ �� �����.<br/>
     * ���������: �� ��������� ������������ ������������ ���� foreach: 
     *  ��� ��������� �������� ������� ����� ����� ��� ������. 
     * @param factor
     */
    void mult(double factor);
    /**
     * ���������� ������ � ������ ��������, ��������� ���������� � ��������� ������� �������.<br/>
     * ���� ������� ����� ������ ������, ��������� �������� �������� ������� �� �����������<br/>
     *  (���� ������ ������ - �������, ��� ������ ������ �� ����, ������ �� ������� ��������� ��������).
     * @param anotherVector �� ����� null
     * @return ������ �� ���� (��������� ��������)
     */
    ArrayVector sum(ArrayVector anotherVector);
    /**
     * ���������� ��������� ������������ ���� ��������.<br/>
     * ���� ������� ����� ������ ������, ��������� �������� �������� ������� �� �����������.
     * @param anotherVector �� ����� null
     */
    double scalarMult(ArrayVector anotherVector);  
    /**
     * ���������� ��������� ����� ������� (����� ������� 
     *  � n-������ ���������� ������������, n={@link #getSize()}).
     * ��� ����� ���������� ��� ������ ���������� �� ���������� ������������ ������� �� ����.
     */
    double getNorm();
}
