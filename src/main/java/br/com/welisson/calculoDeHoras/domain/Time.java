package br.com.welisson.calculoDeHoras.domain;

/**
 * A classe {@link Time} recebe dois inteiros como parametros, o primeiro representando\n
 * a hora e o segundo representando o minuto
 *
 * @author Welisson Oliveira
 * @version 1.0 03/07/2017
 */
public class Time {
	private final int HOURS_IN_A_DAY = 24;
	private final int MINUTES_IN_AN_HOUR = 60;
	private int hour;
	private int minute;

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public Time subtractHour(int hour) {
		int tempHour = this.hour - hour;
		if(tempHour < 0){
			this.hour = HOURS_IN_A_DAY - tempHour;
		}else{
			this.hour = tempHour;
		}
		return this;
	}

	public Time subtractMinute(int minute) {
		int tot = this.minute - minute;
		if (tot < 0) {
			tot = MINUTES_IN_AN_HOUR + tot;
			this.hour--;
		}

		this.minute = tot;
		return this;
	}

	public Time sumHour(int hour) {
		int tempHour = this.hour + hour;
		if(tempHour > HOURS_IN_A_DAY){
			this.hour = tempHour - HOURS_IN_A_DAY;
		}else{
			this.hour = tempHour;
		}
		return this;
	}

	public Time sumMinute(int minute) {
		int tempMinutes = this.minute + minute;
		if(tempMinutes >= MINUTES_IN_AN_HOUR){
			this.minute = tempMinutes - MINUTES_IN_AN_HOUR;
			this.hour++;
		}else{
			this.minute = tempMinutes;
		}
		return this;
	}

	public Time sumTime(Time time){
		sumMinute(time.getMinute());
		sumHour(time.getHour());

		return this;
	}

	public Time subtractTime(Time time) throws Exception {
		subtractMinute(time.getMinute());
		subtractHour(time.getHour());

		if(this.getHour() < 9 ) {
			return this;
		}
		throw new Exception("Horário de saída ja passou");
	}

	@Override public String toString() {
		return this.getHour()+":"+this.getMinute();
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Time time = (Time) o;

		if (hour != time.hour)
			return false;
		return minute == time.minute;
	}

	@Override public int hashCode() {
		int result = hour;
		result = 31 * result + minute;
		return result;
	}
}
