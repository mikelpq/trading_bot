import { OidAndVersion } from "./oid-and-version";

export class Coin extends OidAndVersion{
    name        : string | null = null;
    symbol      : string | null = null;
    buyPrice    : number | null = null;
    sellPrice   : number | null = null;
    spotPrice   : number | null = null;
    currency    : string | null = null;
}