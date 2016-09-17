using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LostShoppingServer.Controllers
{
    public class OrderController : ApiController
    {
        [HttpGet]
        public List<ORDER> ShowAllOrder()
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            return context.ORDERs.ToList();
        }

        // Check Log in
        [HttpGet]
        public ORDER GetByID(int Order_ID)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            ORDER order = context.ORDERs
                .FirstOrDefault(x => x.ORD_ID == Order_ID);
            return order;
        }

        // insert
        [HttpPost]
        public bool InsertOrder(DateTime ord_date, bool ord_paid_status, float ord_total_amount, bool ord_shipping_status, float ord_tota_price,string ord_note, int ord_ser_id, int ord_cus_id, string ord_bill_address, string ord_bill_city, string ord_bill_country, string ord_bill_postcode)
        {
            try
            {
                DataClasses1DataContext context = new DataClasses1DataContext();
                ORDER ord = new ORDER();
                ord.ORD_DATE = ord_date;
                ord.ORD_PAID_STATUS = ord_paid_status;
                ord.ORD_TOTAL_AMOUNT = ord_total_amount;
                ord.ORD_SHIPPING_STATUS = ord_shipping_status;
                ord.ORD_TOTLA_PRICE = ord_tota_price;
                ord.ORD_NOTE = ord_note;
                ord.ORD_SER_ID = ord_ser_id;
                ord.ORD_CUS_ID = ord_cus_id;
                ord.ORD_BILL_ADDRESS = ord_bill_address;
                ord.ORD_BILL_CITY = ord_bill_city;
                ord.ORD_BILL_COUNTRY = ord_bill_country;
                ord.ORD_BILL_POSTCODE = ord_bill_postcode;

                context.ORDERs.InsertOnSubmit(ord); //đánh dấu để lưu
                context.SubmitChanges(); //xác nhận hệ thống là muốn lưu thực sự
                return true;
            }
            catch
            {

            }
            return false;
        }
        // delete
        [HttpDelete]
        public bool DeleteOrder(int ord_id)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            ORDER ord = context.ORDERs.FirstOrDefault(x => x.ORD_ID == ord_id);
            if (ord != null)
            {
                context.ORDERs.DeleteOnSubmit(ord);
                context.SubmitChanges();
                return true;
            }
            return false;
        }

        // update
        [HttpPost]
        public bool UpdateOrder(int ord_id, DateTime ord_date, bool ord_paid_status, float ord_total_amount, bool ord_shipping_status, float ord_tota_price, string ord_note, int ord_ser_id, int ord_cus_id, string ord_bill_address, string ord_bill_city, string ord_bill_country, string ord_bill_postcode)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            ORDER ord = context.ORDERs.Single(x => x.ORD_ID== ord_id);
            if (ord != null)
            {
                ord.ORD_DATE = ord_date;
                ord.ORD_PAID_STATUS = ord_paid_status;
                ord.ORD_TOTAL_AMOUNT = ord_total_amount;
                ord.ORD_SHIPPING_STATUS = ord_shipping_status;
                ord.ORD_TOTLA_PRICE = ord_tota_price;
                ord.ORD_NOTE = ord_note;
                ord.ORD_SER_ID = ord_ser_id;
                ord.ORD_CUS_ID = ord_cus_id;
                ord.ORD_BILL_ADDRESS = ord_bill_address;
                ord.ORD_BILL_CITY = ord_bill_city;
                ord.ORD_BILL_COUNTRY = ord_bill_country;
                ord.ORD_BILL_POSTCODE = ord_bill_postcode;

                context.SubmitChanges();
            }
            return false;
        }

    }
}
