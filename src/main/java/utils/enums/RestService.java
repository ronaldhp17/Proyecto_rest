package utils.enums;

public enum RestService {
    BASE_URL("https://dummy.restapiexample.com/api/v1"),
    GET_EMPLOYEES("/employees"),
    GET_AN_EMPLOY("/employee/1"),
    CREATE_EMPLOYE("/create"),
    UPDATE_EMPLOYE("/update/21"),
    DELETE_EMPLOY("/delete/2");

    private String uri;

    RestService(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return uri;
    }
}
