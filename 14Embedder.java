public class 14Embedder extends Embedder {
  
    @Override
    public InjectableStepsFactory stepsFactory() {
        return
        	new InstanceStepsFactory(
        		configuration(), new 14());
    }
    
    //...
	
	@Override
    public EmbedderControls embedderControls() {
        
		EmbedderControls controls
        	= new EmbedderControls();
		controls.doIgnoreFailureInStories(false);
		controls.doIgnoreFailureInView(true);
		
		return controls;
    }
 
    @Override
    public Configuration configuration() {
    	        
        MostUsefulConfiguration configuration =
        	new MostUsefulConfiguration();
        
        ClassLoader classLoader =
        	this.getClass().getClassLoader();
        
		StoryLoader loader = 
        	new LoadFromClasspath(classLoader);

        configuration.useStoryLoader(loader);
        
        StoryReporterBuilder builder =
        	getStoryReporterBuilder();
        configuration.useStoryReporterBuilder(builder);
        
        ParameterConverters converters =
        	getParameterConverters();
        configuration.useParameterConverters(converters);
        
        StepPatternParser stepPatternParser = 
        	new RegexPrefixCapturingPatternParser("$");
		configuration.useStepPatternParser(stepPatternParser);
		
		StepMonitor stepMonitor = 
			new SilentStepMonitor();
        configuration.useStepMonitor(stepMonitor);
        
        return configuration;

    }

	private StoryReporterBuilder getStoryReporterBuilder() {
		
		StoryReporterBuilder builder =
			new StoryReporterBuilder();
		
        Class<? extends 14Embedder> embedderClass =
            this.getClass();
        
        URL codeLocation =
        	CodeLocations.codeLocationFromClass(embedderClass);
		
        builder.withCodeLocation(codeLocation);
        
        builder.withFormats(Format.STATS,Format.HTML,Format.XML);
                
        builder.withCrossReference(new CrossReference());
		return builder;
	}

	private ParameterConverters getParameterConverters() {
		ParameterConverters converters =
			new ParameterConverters();
        
        SimpleDateFormat dateFormat = 
        	new SimpleDateFormat("yyyy-MM-dd");
        
        DateConverter dateConverter =
        	new DateConverter(dateFormat);
        
        converters.addConverters(dateConverter);
		return converters;
	}
}
