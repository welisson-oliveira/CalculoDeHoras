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
 * {@link TimesDeserializer}
 *
 * @author Welisson Oliveira
 * @version 1.0 13/10/2017
 */
public class TimesDeserializer extends JsonDeserializer {

	@Override public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		final ObjectCodec objectCodec = jsonParser.getCodec();
		final JsonNode node = objectCodec.readTree(jsonParser);

		final JsonNode jsonNodeEntryTime = node.get("entryTime");
		final JsonNode jsonNodeLunchTimeInit = node.get("lunchTimeInit");
		final JsonNode jsonNodeLunchTimeEnd = node.get("lunchTimeEnd");

		final Time entryTime = new Time(jsonNodeEntryTime.get("hour").asInt(), jsonNodeEntryTime.get("minutes").asInt());
		final Time lunchTimeInit = new Time(jsonNodeLunchTimeInit.get("hour").asInt(), jsonNodeLunchTimeInit.get("minutes").asInt());
		final Time lunchTimeEnd = new Time(jsonNodeLunchTimeEnd.get("hour").asInt(), jsonNodeLunchTimeEnd.get("minutes").asInt());

		return new TimesWrapper(entryTime,lunchTimeInit,lunchTimeEnd);
	}
}
