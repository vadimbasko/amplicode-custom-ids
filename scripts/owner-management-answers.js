const { esc, btoa } = require("./common");
const {ownerListQuery, ownerDetailsQuery, ownerDeleteMutation, ownerUpsertMutation} = require("./queries");

const ownerManagementAnswers = btoa(JSON.stringify({
    listComponentName: 'OwnerCards',
    itemComponentName: 'OwnerCardsEditor',
    route: 'owner-cards',
    shouldAddToMenu: true,
    listQuery: esc(ownerListQuery),
    detailsQuery: esc(ownerDetailsQuery),
    deleteMutation: esc(ownerDeleteMutation),
    upsertMutation: esc(ownerUpsertMutation),
}));

console.log(ownerManagementAnswers);
