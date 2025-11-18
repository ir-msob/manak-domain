package ir.msob.manak.domain.model.workflow.workflow;

import com.fasterxml.jackson.core.type.TypeReference;
import ir.msob.jima.core.commons.channel.ChannelMessage;
import ir.msob.jima.core.commons.channel.message.*;
import ir.msob.jima.core.commons.shared.PageResponse;
import ir.msob.manak.core.model.jima.channel.ChannelTypeReference;
import ir.msob.manak.core.model.jima.domain.DtoTypeReference;
import ir.msob.manak.core.model.jima.security.User;

import java.lang.reflect.Type;

public interface WorkflowTypeReference
        extends DtoTypeReference<WorkflowDto, WorkflowCriteria>
        , ChannelTypeReference<WorkflowDto, WorkflowCriteria> {

    @Override
    default TypeReference<PageResponse<WorkflowDto>> getPageResponseReferenceType() {
        return new TypeReference<PageResponse<WorkflowDto>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<WorkflowCriteria> getCriteriaReferenceType() {
        return new TypeReference<WorkflowCriteria>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<WorkflowDto> getDtoReferenceType() {
        return new TypeReference<WorkflowDto>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, CriteriaMessage<String, WorkflowCriteria>>> getChannelMessageCriteriaReferenceType() {
        return new TypeReference<ChannelMessage<User, CriteriaMessage<String, WorkflowCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageableMessage<String, WorkflowCriteria>>> getChannelMessagePageableReferenceType() {
        return new TypeReference<ChannelMessage<User, PageableMessage<String, WorkflowCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, PageMessage<String, WorkflowDto>>> getChannelMessagePageReferenceType() {
        return new TypeReference<ChannelMessage<User, PageMessage<String, WorkflowDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, JsonPatchMessage<String, WorkflowCriteria>>> getChannelMessageJsonPatchReferenceType() {
        return new TypeReference<ChannelMessage<User, JsonPatchMessage<String, WorkflowCriteria>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtoMessage<String, WorkflowDto>>> getChannelMessageDtoReferenceType() {
        return new TypeReference<ChannelMessage<User, DtoMessage<String, WorkflowDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }

    @Override
    default TypeReference<ChannelMessage<User, DtosMessage<String, WorkflowDto>>> getChannelMessageDtosReferenceType() {
        return new TypeReference<ChannelMessage<User, DtosMessage<String, WorkflowDto>>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };
    }
}