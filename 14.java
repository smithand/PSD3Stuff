public class 14{

	private Logindetails logindetails;
	//...
	
	private Connected connected;
	private Option currentOption; 
	//...
		
	@Given("login details")
	public void Login(){
		this.logindetails = new Logindetails();		
	}
	
	@When("loged in and $connected to the system")
	public void connected(String connected){
		
		logindetails = 
			Logindetails.valueOf();
				
		connected.setConnected("True");
	}
	
	@When("$timetable for a session is selected ")
	public void sessionoption(String option){

		currentOption = option;

		session.getTimetable();

	}
	
	@Then("the $timetable of the session are shown")
	public void timetable(Timetable timetable){
		
		Timetable actual =
			Timetable.getTimetable();
						
		assertThat(actual, equalTo(timetable));
	}
