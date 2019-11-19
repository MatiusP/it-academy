package by.it.protsko.jd01_09;

interface Patterns {

    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
    //String MATRIX ="\\{(\\{(-?[0-9]+(\\.[0-9]+)?)(,(-?[0-9]+(\\.[0-9]+)?))*})(,\\{(-?[0-9]+(\\.[0-9]+)?)(,(-?[0-9]+(\\.[0-9]+)?))*})*\\}";
    String OPERATIONS = "[-+*/]";
}
