package br.com.welisson.calculoDeHoras.restapi;

import br.com.welisson.calculoDeHoras.domain.Time;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * {@link TimeDeserializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/10/2017
 */
public class TimeDeserializer extends JsonDeserializer {

	@Override public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		final ObjectCodec objectCodec = jsonParser.getCodec();
		final JsonNode node = objectCodec.readTree(jsonParser);

		Time time = new Time(node.get("hour").asInt(), node.get("minutes").asInt());

		return new TimeWrapper(time);
	}
}
