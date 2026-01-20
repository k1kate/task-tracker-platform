import NavbarV from "../components/NavbarV.jsx";
import CardGlass from "../components/CardGlass.jsx";
import { useState } from "react";
import Organization from "../components/Organization.jsx";
import Structure from "../components/Structure.jsx";
import Status from "../components/Status.jsx";
import Post from "../components/Post.jsx";
import AddTasks from "../components/AddTasks.jsx";
import Users from "../components/AddUsers.jsx";

function AdminPanelPage() {
    const [activeTab, setActiveTab] = useState(null);
    const [showCard, setShowCard] = useState(false);

    const handleMenuClick = (tab) => {
        if (activeTab === tab) {
            // повторный клик по той же — скрыть
            setShowCard(false);
            setActiveTab(null);
        } else {
            setActiveTab(tab);
            setShowCard(true);
        }
    };

    return (
        <div className='container-admin-1'>
            <NavbarV onSelect={handleMenuClick} ></NavbarV>
            <div className='container-admin-2'>
                <CardGlass classname={showCard ? "card-show" : "card-hide"}>
                    {activeTab === "org" && <Organization />}
                    {activeTab === "structure" && <Structure />}
                    {activeTab === "status" && <Status />}
                    {activeTab === "post" && <Post />}
                    {activeTab === "task" && <AddTasks />}
                    {activeTab === "users" && <Users />}
                </CardGlass>
            </div>
        </div>
    )
}

export default AdminPanelPage;
