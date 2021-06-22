
public class Track {
	
	String songName;
	String artist;
	String mp3FileLocation;
	
	public String getMp3() {
		return mp3FileLocation;
	}
	public void setMp3(String mp3) {
		this.mp3FileLocation = mp3;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String toString() {
		return getSongName();
	}
	
	public boolean equals(Object o) {
		if(o.toString().equalsIgnoreCase(getSongName()))
			return true;
		else
			 return false;
	}	
	

}
