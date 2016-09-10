using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LostShoppingServer.Controllers
{
    public class CustomerController : ApiController
    {
        [HttpGet]
        public List<CUSTOMER>ShowAllCustomer()
        {
            CustomerManagerDataContext context = new CustomerManagerDataContext();
            return context.CUSTOMERs.ToList();
        }

        [HttpGet]
        public CUSTOMER LogIn(string account, string password)
        {
            CustomerManagerDataContext context = new CustomerManagerDataContext();
            CUSTOMER customer = context.CUSTOMERs
                .FirstOrDefault(x => x.CUS_ACCOUNT == account && x.CUS_PASS == password);
            return customer;
        }
    }
}
