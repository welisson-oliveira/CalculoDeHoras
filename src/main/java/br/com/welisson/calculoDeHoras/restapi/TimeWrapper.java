package br.com.welisson.calculoDeHoras.restapi;

import br.com.welisson.calculoDeHoras.domain.Time;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * {@link TimeWrapper}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/10/2017
 */
@JsonSerialize(using = TimeSerializer.class)
@JsonDeserialize(using = TimeDeserializer.class)
public class TimeWrapper {

	private final Time time;

	public TimeWrapper(final Time time) {
		this.time = time;
	}

	public Time getTime() {
		return time;
	}
}
