package br.com.welisson.calculoDeHoras.restapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.welisson.calculoDeHoras.domain.Calculates;
import br.com.welisson.calculoDeHoras.domain.Time;
import lombok.AllArgsConstructor;

/**
 * {@link CalculatesController}
 *
 * @author Welisson Oliveira
 * @version 1.0 09/10/2017
 */
@RestController
@AllArgsConstructor
public class CalculatesController extends AbstractController {

	private final Calculates calculates;

	@PostMapping(value="/calculates/missingTime")
	public TimeWrapper missingTime(@RequestBody final TimeWrapper entryTime) throws Exception {

		return new TimeWrapper(calculates.missingTime(entryTime.getTime()));
	}

	@PostMapping(value="/calculates/likelyExit")
	public TimeWrapper likelyExit(@RequestBody final TimeWrapper entryTime){
		final Time result = calculates.likelyExit(entryTime.getTime());
		return new TimeWrapper(result);
	}

	@PostMapping(value="/calculates/exitTime")
	public TimeWrapper exitTime(@RequestBody final TimesWrapper times){
		final Time result = calculates.exitTime(times.getEntryTime(), times.getLunchTimeInit(), times.getLunchTimeEnd());
		return new TimeWrapper(result);
	}

}
