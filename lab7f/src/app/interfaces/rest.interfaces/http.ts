import { Bags } from "../bags";
import { Page } from "./page";
import { RootLinks } from "./root_links";

export interface Http {
    _embedded: {
      bags: Bags[];
    };
    _links: RootLinks;
    page: Page;
  }