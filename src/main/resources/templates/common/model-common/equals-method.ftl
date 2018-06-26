    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ${entity.name} ${entity.name?uncap_first} = (${entity.name}) o;
        if (${entity.name?uncap_first}.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ${entity.name?uncap_first}.getId());
    }
    