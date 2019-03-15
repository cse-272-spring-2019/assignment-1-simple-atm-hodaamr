public class Authentication {
	String card="1234";

    public boolean validate (String cardnumber) {
	     boolean validationResult;
	
	    if (cardnumber.equals(card)) 
	    	validationResult = true;
	    else 
		    validationResult = false;
	
	    return validationResult;
	
}

}
