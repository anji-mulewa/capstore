export class orderdata{

    constructor(
 
        public email: string,
        public address: string,
        public pincode: number,
        public totalbill: string,
        public paymentMode: string,
        public productQuality: number,
        public productName: string,
        public productId: number
  

    ) { }
}