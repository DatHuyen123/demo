package com.dangvandat.builder;

public class CustomerSearchBuilder {

    private Long staffId;
    private String fullName;
    private String email;
    private String phone;
    private String companyName;

    public Long getStaffId() {
        return staffId;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getCompanyName() {
        return companyName;
    }

    public CustomerSearchBuilder(builder builder){
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.staffId = builder.staffId;
        this.companyName = builder.companyName;
    }

    public static class builder {
        private Long staffId;
        private String fullName;
        private String email;
        private String phone;
        private String companyName;

        public builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
        public builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public CustomerSearchBuilder builder(){
            return new CustomerSearchBuilder(this);
        }
    }
}
