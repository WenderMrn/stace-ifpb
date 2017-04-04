package br.edu.ifpb.stace.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {
	
	public static Date stringToDate(String dataString) throws Exception{
		Date date = null;
		
		if(dataString == null || dataString.isEmpty()) {
			throw new Exception("Data de aniversário é campo obrigatório!"); 
		} else{
			if(dataString.matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2,2}")) {
				try{
					SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
					sdf.setLenient(false);
					date= sdf.parse(dataString);
					
				} catch(ParseException e){
					throw new Exception("Data inválida para a data de aniversário!");
				}
			}else if(dataString.matches("(19|20)\\d{2,2}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])")) {
				/* validação para o chrome */
				try{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					sdf.setLenient(false);
					date = sdf.parse(dataString);
		
				} catch(ParseException e) {
					throw new Exception("Data inválida para a data de aniversário!");
				}
				
			} else{
				throw new Exception("Formato inválido para a data de aniversário (use dd/mm/yyyy)!");
			}
		}
		return date;
	}

}
