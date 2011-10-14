package com.ft.unifiedContentModel.marshalling.bind;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * This class extends the ObjectMapper class of the Jackson framework to provide
 * minor customisations:
 * - read in both JAXB and Jackson annotations (JAXB as the primary)
 * - support for easily setting dates as formatted vs timestamps
 * - support for easily setting pretty printing on or off
 * 
 * Note:Due to the nature of the ObjectMapper class
 * these customisations could not be done through the Spring Framework configuration
 * (or at least not easily)
 *
 */
public class JAXBandJacksonObjectMapper extends ObjectMapper {

	public JAXBandJacksonObjectMapper(AnnotationIntrospector annotationIntrospector) {
		setSerializationConfig(getSerializationConfig().withAnnotationIntrospector(annotationIntrospector));
	}

    public void setPrettyPrint(boolean prettyPrint) {
        configure(SerializationConfig.Feature.INDENT_OUTPUT, prettyPrint);
    }

    public void setWriteDatesAsTimestamps(boolean writeDatesAsTimeStamps) {
        configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, writeDatesAsTimeStamps);
    }
}