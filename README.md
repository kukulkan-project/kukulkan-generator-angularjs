# Kukulkán Meta-Model
 
## Template key-params

#### Project

`projectName` : the name of the project

#### Entity

`entity`: Name of the entity

`entityHyphenNotation`: hyphen notation of the entity

`entityHyphenNotationPlural`: hyphen notation in plural format of the entity

`entityCamelCase`: entity in camel-case notation

`entityCamelCasePlural`: entity in camel-case plural format

`hasBlobProperties`: true if the entity has blob properties, false otherwise

`hasTimeProperties`: true if the entity has time properties, false otherwise

`hasLocalDate`: true if the entity has LocalDate properties, false otherwise

## Properties

### Entity

#### General Information

`property.name`: the name of the property in camelCase format 

`property.type`: the type of the property in camelCase format 

`property.qualifiedName`: the qualifiedName in java world 

`property.columnType`: the type of the property in the datamodel representation 

`property.literal`: true if the property is String, false otherwise 

#### For Blob o Clob

`property.blob`: true if the property is blob, false otherwise 

`property.clob`: true if the property is clob, false otherwise 

#### For numbers

`property.time`: true if the property is time (LocalDate, Instant, ZoneDateTime), false otherwise 

`property.localDate`: true if the property is localDate, false otherwise 

`property.instant`: true if the property is instant, false otherwise 

`property.zoneDateTime`: true if the property is zoneDateTime, false otherwise 

#### For numbers

`property.number`: true if the property is a Number (Integer, Long, Double, Float, BidDecimal), false otherwise 

`property.long`: true if the property is Long, false otherwise 

`property.integer`: true if the property is Integer, false otherwise 

`property.float`: true if the property is Float, false otherwise 

`property.double`: true if the property is Double, false otherwise 

`property.bigDecimal`: true if the property is bigDecimal, false otherwise 

#### Constraint

`property.hasConstraint`: true if the property is has constraints, false otherwise. 

`property.constraint.nullable`: true if the property can be null, false otherwise.

`property.constraint.primaryKey`:

`property.constraint.unique`:

`property.constraint.uniqueConstraintName`:

`property.constraint.deleteCascade`:

`property.constraint.deferrable`:

`property.constraint.initiallyDeferred`:

#### For text - Constraint

`property.constraint.minLength`:

`property.constraint.maxLength`:

`property.constraint.pattern`:

#### For Numbers (Integer, Long, Float, Double) - Constraint

`property.constraint.minNumber`:

`property.constraint.maxNumber`:

#### For Blob - Constraint

`property.constraint.minByte`:

`property.constraint.maxByte`:


### template quick reference

`property.columnType?contains("TIMESTAMP")`

`property.columnType?cap_first`

