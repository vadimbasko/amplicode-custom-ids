export function getOwnerDisplayName<TEntity extends Record<string, unknown>>(
  entityInstance?: TEntity
): string {
  if (entityInstance == null) {
    return "";
  }
  if (entityInstance.firstName != null && entityInstance.lastName != null) {
    return String(`${entityInstance.firstName} ${entityInstance.lastName}`);
  }
  if (entityInstance.firstName != null) {
    return String(entityInstance.firstName);
  }
  if (entityInstance.lastName != null) {
    return String(entityInstance.lastName);
  }
  return JSON.stringify(entityInstance);
}
