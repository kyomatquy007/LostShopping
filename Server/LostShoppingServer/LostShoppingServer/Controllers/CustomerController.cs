using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data;

namespace LostShoppingServer.Controllers
{
    public class CustomerController : ApiController
    {

        // Get all data
        [HttpGet]
        public List<CUSTOMER>ShowAllCustomer()
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            return context.CUSTOMERs.ToList();
        }

        // Check Log in
        [HttpGet]
        public CUSTOMER LogIn(string account, string password)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            CUSTOMER customer = context.CUSTOMERs
                .FirstOrDefault(x => x.CUS_ACCOUNT == account && x.CUS_PASS == password);
            return customer;
        }
        // insert
        [HttpPost]
        public bool InsertCustomer(string acc, string pass, string first_name, string last_name, string email)
        {
            try
            {
                DataClasses1DataContext context = new DataClasses1DataContext();
                CUSTOMER cus = new CUSTOMER();

                cus.CUS_ACCOUNT = acc;
                cus.CUS_PASS = pass;
                cus.CUS_FIRSTNAME = first_name;
                cus.CUS_LASTNAME = last_name;
                //cus.CUS_ADDRESS = address;
                //cus.CUS_CITY = city;
                //cus.CUS_COUNTRY = country;
                //cus.CUS_PHONE = phone;
                cus.CUS_EMAIL = email;
                cus.CUS_REGISTRATION_DATE = DateTime.Now;

                context.CUSTOMERs.InsertOnSubmit(cus); //đánh dấu để lưu
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
        public bool DeleteCustomer(int id)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            CUSTOMER cus = context.CUSTOMERs.FirstOrDefault(x => x.CUS_ID == id);
            if (cus != null)
            {
                context.CUSTOMERs.DeleteOnSubmit(cus);
                context.SubmitChanges();
                return true;
            }
            return false;
        }
        // update
        [HttpPost]
        public bool UpdateCustommer(string acc, string pass, string first_name, string last_name, string address, string city, string country, string phone, string email)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            CUSTOMER cus = context.CUSTOMERs.Single(x => x.CUS_ACCOUNT == acc);
            if (cus != null)
            {
                cus.CUS_PASS = pass;
                cus.CUS_FIRSTNAME = first_name;
                cus.CUS_LASTNAME = last_name;
                cus.CUS_ADDRESS = address;
                cus.CUS_CITY = city;
                cus.CUS_COUNTRY = country;
                cus.CUS_PHONE = phone;
                cus.CUS_EMAIL = email;
                context.SubmitChanges();
            }
            return false;
        }
    }
}
