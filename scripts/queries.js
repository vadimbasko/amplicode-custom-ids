exports.ownerListQuery = `query Get_Owner_List {
    ownerList {
      ownerId
      firstName
      lastName
    }
  }`;

exports.ownerDeleteMutation = `mutation Delete_Owner($id: ID!) {
    deleteOwner(ownerId: $id)
  }`;

exports.ownerDetailsQuery = `query Get_Owner($id: ID) {
    owner(ownerId: $id) {
      ownerId
      firstName
      lastName
    }
  }`;

exports.ownerUpsertMutation = `mutation Update_Owner($input: OwnerInputDTOInput) {
    updateOwner(input: $input) {
      ownerId
    }
  }`;

