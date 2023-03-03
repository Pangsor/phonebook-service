# phonebook-service
Phonebook RESTFull API Service

CREATE TABLE public.contacts (
id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
created_at timestamp NOT NULL,
"name" varchar(255) NOT NULL,
phone varchar(255) NOT NULL,
updated_at timestamp NOT NULL,
CONSTRAINT contacts_pkey PRIMARY KEY (id)
);

# Create a contact
curl --location 'http://localhost:8086/api/v1/contacts' \
--header 'Content-Type: application/json' \
--data '{
"name":"Valen",
"phone":"08323456789"
}'

# Get a contact
curl --location 'http://localhost:8086/api/v1/contacts/1'

# Get all contact
curl --location 'http://localhost:8086/api/v1/contacts'

# Update a contact
curl --location --request PUT 'http://localhost:8086/api/v1/contacts/1' \
--header 'Content-Type: application/json' \
--data '{
"name":"Fulan updated",
"phone":"083234567899"
}'

# Delete a contact
curl --location --request DELETE 'http://localhost:8086/api/v1/contacts/1'
