public class Address {

    private final String street;
    private final Integer streetNumber;
    private final String city;
    private final Integer zipCode;


    public Address(String street, Integer streetNumber, String city, Integer zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        if (isRightSize(zipCode)) {
            this.zipCode = zipCode;
        } else {
            throw new ZipCodeLengthException(zipCode);
        }

    }

    public boolean isRightSize(int zipCode) {
        int zipCodeSize = String.valueOf(zipCode).length();
        return zipCodeSize == 5 || zipCodeSize == 9;
    }


    @Override
    public String toString() {
        return "Street: " + street +
                "\nStreet number: " + streetNumber +
                "\nCity: " + city +
                "\nZip code: " + zipCode;
    }

}






