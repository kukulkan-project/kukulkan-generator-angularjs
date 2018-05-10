
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ${entity} ${entity?uncap_first} = (${entity}) o;
        if (${entity?uncap_first}.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ${entity?uncap_first}.getId());
    }