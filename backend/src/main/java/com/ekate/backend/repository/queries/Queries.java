package com.ekate.backend.repository.queries;

public class Queries {
    public static final String createOrganisationQuery
            = "INSERT INTO organization(uuid,organization_name,setup_complete) values (?,?,?)";

}
