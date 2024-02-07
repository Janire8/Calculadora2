package formatoslogs;


	import java.util.logging.Formatter;
	import java.util.logging.Handler;
	import java.util.logging.LogRecord;
	public class FormatoHTML extends Formatter {
	@Override
	public String format(LogRecord record) {
		int ope1, ope2, resu;
        String opera;
        String linea=record.getMessage();
        String[] trozo;
        trozo=linea.split(";");
        ope1=Integer.parseInt(trozo[0]);
        opera=trozo[1];
        ope2=Integer.parseInt(trozo[2]);
        resu=Integer.parseInt(trozo[3]);
        return "<tr>\n" + "<td>"+ ope1 + "</td>\n" + "<td>"+ opera + "</td>\n"+ "<td>"+ ope2 + "</td>\n" + "<td>"+ resu + "</td>\n" + "</tr>\n";
	
	}
	@Override
	 public String getHead(Handler h) {
	 return "<HTML>\n"
	 		+ "<head>\r\n"
	 		+ "  <title>FormatoHtml</title>\r\n"
	 		+ "  <link href=\"./style.css\" rel=\"stylesheet\">\r\n"
	 		+ "</head>"
	 		+ " <BODY> \n "
	 		+ "<table> \n "
	 		+ "<tr> \n "
	 		+ "<th> Operando1 </th> \n"
	 		+ "<th> Operacion </th> \n"
	 		+ "<th> Operando2 </th> \n"
	 		+ "<th> Resultado </th \n"
	 		+ "</tr>  \n";
	 }
	@Override
	 public String getTail(Handler h) {
	 return "</table> \n"
	 		+ " </BODY>\n"
	 		+ " </HTML>\n";
	 }
	
}
