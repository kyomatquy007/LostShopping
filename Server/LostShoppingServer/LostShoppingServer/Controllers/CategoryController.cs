using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LostShoppingServer.Controllers
{
    public class CategoryController : ApiController
    {
        //show data by ID
        [HttpGet]
        public CATEGORY getDataByID(int ID)
        {
            CategoryDataContext context = new CategoryDataContext();
            CATEGORY category = context.CATEGORies.FirstOrDefault(x => x.CAT_ID == ID);
            return category;
        }
    }
}
