import React from "react";
import { OwnerCards } from "../app/screens/owner/OwnerCards";
import { OwnerCardsEditor } from "../app/screens/owner/OwnerCardsEditor";
import { ComponentPreview, Previews } from "@react-buddy/ide-toolbox";
import { PaletteTree } from "./palette";

const ComponentPreviews = () => {
  return (
    <Previews palette={<PaletteTree />}>
      <ComponentPreview path="/OwnerCardsEditor">
        <OwnerCardsEditor />
      </ComponentPreview>
      <ComponentPreview path="/OwnerCards">
        <OwnerCards />
      </ComponentPreview>
    </Previews>
  );
};

export default ComponentPreviews;
