package cn.vworld.bean;

public class EchartDate {
    private String MovieName;
    private String Allboxoffice;
    private String Dayboxoffice;
    private String Movielink;
    private String MovieTile;


    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }


    public String getAllboxoffice() {
        return Allboxoffice;
    }

    public void setAllboxoffice(String allboxoffice) {
        Allboxoffice = allboxoffice;
    }

    public String getMovielink() {
        return Movielink;
    }

    public void setMovielink(String movielink) {
        Movielink = movielink;
    }

    public String getMovieTile() {
        return MovieTile;
    }

    public void setMovieTile(String movieTile) {
        MovieTile = movieTile;
    }

    public String getDayboxoffice() {
        return Dayboxoffice;
    }

    public void setDayboxoffice(String dayboxoffice) {
        Dayboxoffice = dayboxoffice;
    }

    @Override
    public String toString() {
        return "EchartDate{" +
                "MovieName='" + MovieName + '\'' +
                ", Allboxoffice='" + Allboxoffice + '\'' +
                ", Dayboxoffice='" + Dayboxoffice + '\'' +
                ", Movielink='" + Movielink + '\'' +
                ", MovieTile='" + MovieTile + '\'' +
                '}';
    }
}
