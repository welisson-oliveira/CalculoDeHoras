package br.com.welisson.calculoDeHoras.restapi;

import br.com.welisson.calculoDeHoras.domain.Time;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link TimesWrapper}
 *
 * @author Welisson Oliveira
 * @version 1.0 13/10/2017
 */
@AllArgsConstructor
@Getter
@JsonDeserialize(using = TimesDeserializer.class)
public class TimesWrapper {
	private final Time entryTime;
	private final Time lunchTimeInit;
	private final Time lunchTimeEnd;
}
