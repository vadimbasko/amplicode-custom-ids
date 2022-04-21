import { OwnerCards } from "../../app/screens/owner/OwnerCards";
import { Home } from "../../app/screens/home/Home";
import { screenStore } from "@amplicode/react-core";

screenStore.registerScreen("home", {
  component: Home,
  captionKey: "screen.home"
});

screenStore.registerScreen("owner-cards", {
  component: OwnerCards,
  captionKey: "screen.OwnerCards"
});
