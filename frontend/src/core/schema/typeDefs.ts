export const typeDefs = /* GraphQL */ `
  # Mutation root
  type Mutation {
    deleteOwner(ownerId: ID): Void
    deleteTestEntity(id: ID): Void
    updateOwner(input: OwnerInput): Owner
    updateTestEntity(input: TestEntityInput): TestEntity
  }

  type Owner {
    ownerId: ID
  }

  # Query root
  type Query {
    owner(ownerId: ID): Owner
    ownerList: [Owner]
    testEntity(id: ID): TestEntity
    testEntityList: [TestEntity]
    userInfo: UserInfo
  }

  type TestEntity {
    id: ID
  }

  type UserInfo {
    username: String
  }

  # Java Type: BigDecimal
  scalar BigDecimal

  # Java Type: BigInteger
  scalar BigInteger

  # Java Type: LocalDate
  scalar Date

  # Java Type: OffsetDateTime
  scalar DateTime

  # Java Type: LocalDateTime
  scalar LocalDateTime

  # Java Type: LocalTime
  scalar LocalTime

  # Java Type: Long, long
  scalar Long

  # Java Type: OffsetTime
  scalar Time

  # Java Type: Date
  scalar Timestamp

  # Java Type: URL
  scalar Url

  # Java Type: Void
  scalar Void

  input OwnerInput {
    ownerId: ID
  }

  input TestEntityInput {
    id: ID
  }
`;