package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV() {

	}

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	//public void getChannel() {}
	//public void getVolueme(){}
	//public void isPower(){}

	public void power(boolean on){
		this.power = on;
	}

	public void channel(int channel){
		while(channel>255||channel<1) {
			if(channel>255)
				channel -=255;
			else if(channel<1)
				channel +=255;
		}
		this.channel = channel;
	}
	public void channel(boolean up){
		if(up)
			channel(this.channel+1);
		else
			channel(this.channel-1);
	}

	public void volume(int volume){
		while(volume>255||volume<1) {
			if(volume>255)
				volume -=255;
			else if(volume<1)
				volume +=255;
		}
		this.volume = volume;
	}
	public void volume(boolean up){
		if(up)
			volume(this.volume+1);
		else
			volume(this.volume-1);
		// volume(this.volume + (up ? 1 : -1)) // 삼항연산자
	}
	public void status(){
		System.out.println("TV [channel = "+channel+" volume="+volume+" power="+power+"]");
	}
}
