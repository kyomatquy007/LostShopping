using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LostShoppingServer.Controllers
{
    public class SubCategoryController : ApiController
    {
        //show all data
        [HttpGet]
        public List<SUBCATEGORY>showAllSubCategory()
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            return context.SUBCATEGORies.ToList();
        }
        //show subcategory by ID
        [HttpGet]
        public SUBCATEGORY getDataByID(int ID)
        {
            DataClasses1DataContext context = new DataClasses1DataContext();
            SUBCATEGORY subcat = context.SUBCATEGORies.FirstOrDefault(x => x.SUBCAT_ID == ID);
            return subcat;
        }
    }
}
