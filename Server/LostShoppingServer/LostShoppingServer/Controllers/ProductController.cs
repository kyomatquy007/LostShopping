using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LostShoppingServer.Controllers
{
    public class ProductController : ApiController
    {
        //Get all data
        [HttpGet]
        public List<PRODUCT>showAllProduct()
        {
            ProductDataContext context = new ProductDataContext();
            return context.PRODUCTs.ToList();
        }
    }
}
