package utility;

public enum APIEndPoint {
    GET_EMPLOYEE("/employee-management/employee-management/v1/employee/{employeeId}"),
    POST_EMPLOYEE("/employee-management/employee-management/v1/employee"),
    POST_OFFICE("/practice-management/practice-management/v1/offices"),
    POST_PATIENT("/patient-management/patient-management/v1/patients");
    private String endpoint;

    APIEndPoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint(){
        return endpoint;
    }
}
