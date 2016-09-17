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
        //show all data
        [HttpGet]
        public List<CATEGORY> showAllCategory()
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            return context.CATEGORies.ToList();
        }
        //show data by ID
        [HttpGet]
        public CATEGORY getDataByID(int ID)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            CATEGORY category = context.CATEGORies.FirstOrDefault(x => x.CAT_ID == ID);
            return category;
        }
    }
}
