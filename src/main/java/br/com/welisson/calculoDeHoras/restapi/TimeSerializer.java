package br.com.welisson.calculoDeHoras.restapi;

import br.com.welisson.calculoDeHoras.domain.Time;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * {@link TimeSerializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/10/2017
 */
public class TimeSerializer extends JsonSerializer {

	@Override
	public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		final Time time = ((TimeWrapper) obj).getTime();
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("hour", time.getHour());
		jsonGenerator.writeNumberField("minutes", time.getMinute());
		jsonGenerator.writeEndObject();
	}
}
