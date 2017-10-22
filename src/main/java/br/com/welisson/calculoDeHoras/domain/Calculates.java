package br.com.welisson.calculoDeHoras.domain;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@link Calculates}
 *
 * @author Welisson Oliveira
 * @version 1.0 03/07/2017
 */
@Component
public class Calculates {
	private final int MINUTES_IN_AN_HOUR = 60;

	/**
	 * Informa quanto tempo falta pra cumprir o expediente, contando uma hora de almoço
	 * @param t1 - Start time
	 * @return {@link Time}
	 */
	public Time missingTime(Time t1) throws Exception {
		Time missingTime = new Time(9,0).subtractTime(getTimeNow().subtractTime(t1));
		System.out.println(missingTime.toString());
		return missingTime;
	}



	/**
	 * Informa o horário provável de saída desde que voce bata certo o ponto do almoço.
	 * @param t1 - Start time
	 * @return {@link Time}
	 */
	public Time likelyExit(Time t1){

		Time time = t1.sumTime(new Time(9,00));
		return time;
	}


	/**
	 * Informa o horario de saída
	 * @param t1 - Start time
	 * @param t2 - lunch time
	 * @param t3 - lunch time return
	 * @return {@link Time}
	 */
	public Time exitTime(Time t1, Time t2, Time t3) {
		Time finishTime = new Time(t1.getHour(),t1.getMinute());

		Time firstTime = subtractTime(t1, t2);
		Time lunchTime = subtractTime(t2, t3);
		Time timeLeft = subtractTime(firstTime, new Time(8,00));

		finishTime.sumTime(firstTime).sumTime(lunchTime).sumTime(timeLeft);

		return finishTime;
	}

	private Time subtractTime(Time t1, Time t2) {
		int hour;
		int minute = subtractMinute(t2.getMinute(), t1.getMinute());

		if(t2.getMinute() < t1.getMinute()){
			hour = subtractHour(t2.getHour()-1, t1.getHour());
		}else{
			hour = subtractHour(t2.getHour(), t1.getHour());
		}
		return new Time(hour, minute);
	}

	/*private Time sumTime(Time t1, Time t2){
		int minute = sumMinute(t1.getMinute(), t2.getMinute());
		int hour;
		if(minute > MINUTES_IN_AN_HOUR){
			hour = sumHour(t1.getHour(),t2.getHour()+1);
		}else{
			hour = sumHour(t1.getHour(),t2.getHour());
		}
		return new Time(hour, minute);

	}

	private int sumHour(int h1, int h2) {
		return h1 + h2;
	}

	private int sumMinute(int m1, int m2){
		return m1 + m2;
	}*/

	private int subtractHour(int h1, int h2) {
		int tot = h1 - h2;
		return tot;
	}

	private int subtractMinute(int m1, int m2){
		int tot = m1 - m2;
		if(tot < 0){
			tot = MINUTES_IN_AN_HOUR + tot;
		}

		return tot;
	}

	private Time getTimeNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String hour = sdf.format(new Date());
		String[] hourAndMinute = hour.split(":");
		return new Time(Integer.parseInt(hourAndMinute[0]),Integer.parseInt(hourAndMinute[1]));
	}

}
